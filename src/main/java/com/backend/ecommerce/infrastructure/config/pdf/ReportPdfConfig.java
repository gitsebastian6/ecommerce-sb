package com.backend.ecommerce.infrastructure.config.pdf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import com.backend.ecommerce.domain.models.Product;

public class ReportPdfConfig {
    
    static ByteArrayOutputStream createReport(List<Product> products)  throws IOException {
        try (PDDocument document = new PDDocument()) {
            int arraySize = products.size();
            double total = Math.ceil((double) arraySize / 50);
            int index = 0;

            for (int i = 0; i < total; i++) {
                PDPage page = new PDPage();
                document.addPage(page);
                float initPosY = page.getMediaBox().getHeight()-30;

                drawTable(document, page, getColumnsWidth(products), products.subList(index, Math.min(arraySize, index + 50)));
                index += 50;
            }

            ByteArrayOutputStream  buf = new ByteArrayOutputStream();
            document.save(buf);
            return buf;
        }
    }

    private static float[] getColumnsWidth(List<Product> products) {
        float[] columnsWidth = new float[5];
        int maxLength = 0;

        for (Product product : products) {
            if (product.getName().length() > maxLength) {
                maxLength = product.getName().length();
            }
            if (product.getCode().length() > maxLength) {
                maxLength = product.getCode().length();
            }
            if (product.getCharacteristic().length() > maxLength) {
                maxLength = product.getCharacteristic().length();
            }
            if (product.getQuantity().toString().length() > maxLength) {
                maxLength = product.getQuantity().toString().length();
            }
        }

        columnsWidth[0] = 50 * maxLength; // Name
        columnsWidth[1] = 30 * maxLength; // Code
        columnsWidth[2] = 50 * maxLength; // Characteristic
        columnsWidth[3] = 20 * maxLength; // Quantity
        columnsWidth[4] = 50; // Empty space

        return columnsWidth;
    }

    private static void drawTable(PDDocument document, PDPage page, float[] columnsWidth, List<Product> products) throws IOException {
        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);
            contentStream.setLeading(15f);

            float initPosY = page.getMediaBox().getHeight()-30;
            float currentPosY = initPosY;
            float margin = 50;

            // Draw table header
            contentStream.newLineAtOffset(margin, currentPosY);
            drawString(contentStream, "Name", columnsWidth[0]);
            contentStream.newLine();
            drawString(contentStream, "Code", columnsWidth[1]);
            contentStream.newLine();
            drawString(contentStream, "Characteristic", columnsWidth[2]);
            contentStream.newLine();
            drawString(contentStream, "Quantity", columnsWidth[3]);
            contentStream.newLine();
            currentPosY -= 15;
            drawLine(contentStream, margin,currentPosY, columnsWidth[0], columnsWidth[4]);

            // Draw table rows
            for (Product product : products) {
                currentPosY -= 15;
                contentStream.newLineAtOffset(margin, currentPosY);
                drawString(contentStream, product.getName(), columnsWidth[0]);
                contentStream.newLine();
                drawString(contentStream, product.getCode(), columnsWidth[1]);
                contentStream.newLine();
                drawString(contentStream, product.getCharacteristic(), columnsWidth[2]);
                contentStream.newLine();
                drawString(contentStream, product.getQuantity().toString(), columnsWidth[3]);
                contentStream.newLine();
                drawLine(contentStream, margin, currentPosY, columnsWidth[0], columnsWidth[4]);
            }
        }
    }

    private static void drawString(PDPageContentStream contentStream, String text, float width) throws IOException {
        contentStream.showText(text);
        contentStream.newLineAtOffset(width, 0);
    }

    private static void drawLine(PDPageContentStream contentStream, float startX, float startY, float endX, float endY) throws IOException {
        contentStream.moveTo(startX, startY);
        contentStream.lineTo(endX, endY);
        contentStream.stroke();
    }
}