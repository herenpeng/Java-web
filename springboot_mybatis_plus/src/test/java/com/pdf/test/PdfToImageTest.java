package com.pdf.test;

import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.util.GraphicsRenderingHints;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

/**
 * @description: pdf文件转换为图片测试
 * @author: 何任鹏
 * @create: 2020/9/2 19:29
 */
public class PdfToImageTest {

    @Test
    public void test01() throws IOException, PDFException, PDFSecurityException, InterruptedException {
        Document document = new Document();
        document.setFile("C:/Users/hp/Desktop/何任鹏+江西农业大学南昌商学院+2020届.pdf");

        for (int i = 0; i < document.getNumberOfPages(); i++) {
            BufferedImage image = (BufferedImage) document.getPageImage(i,
                    GraphicsRenderingHints.SCREEN,
                    org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX, 0F,
                    2.5F);
            File imageFile = new File("C:/Users/hp/Desktop/0" + i + ".png");
            ImageIO.write(image, "png", imageFile);
            image.flush();
        }
        document.dispose();

    }

}
