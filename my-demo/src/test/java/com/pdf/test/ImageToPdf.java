package com.pdf.test;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @description: 图片转换为pdf
 * @author: 何任鹏
 * @create: 2020/8/24 19:51
 */
public class ImageToPdf {

    @Test
    public void test01() throws IOException, DocumentException {
        ArrayList<String> imageList = new ArrayList<String>();
        imageList.add("C:\\Users\\hp\\Pictures\\Camera Roll\\雄兵连图片\\雄兵连-彦.jpg");
        String pdfUrl = "C:\\Users\\hp\\Pictures\\Camera Roll\\雄兵连图片\\雄兵连-彦.pdf";
        File file = pdf(imageList, pdfUrl);
        file.createNewFile();
    }

    public File pdf(ArrayList<String> imageList, String mOutputPdfFileName) throws IOException, DocumentException {
        Document doc = new Document(PageSize.A4, 20, 20, 20, 20);
        PdfWriter.getInstance(doc, new FileOutputStream(mOutputPdfFileName));
        doc.open();
        for (int i = 0; i < imageList.size(); i++) {
            doc.newPage();
            Image image = Image.getInstance(imageList.get(i));
            float height = image.getHeight();
            float width = image.getWidth();
//            int percent = getPercent(height, width);
            int percent = getPercentByWeight(width);
            image.setAlignment(Image.MIDDLE);
            image.scalePercent(percent);
            doc.add(image);
        }
        doc.close();
        File mOutputPdfFile = new File(mOutputPdfFileName);
        if (!mOutputPdfFile.exists()) {
            mOutputPdfFile.deleteOnExit();
            return null;
        }
        return mOutputPdfFile;
    }

    /**
     * 第一种解决方案 在不改变图片形状的同时，判断，如果h>w，则按h压缩，否则在w>h或w=h的情况下，按宽度压缩
     *
     * @param height
     * @param weight
     * @return
     */
    public int getPercent(float height, float weight) {
        float percent = 0.0F;
        if (height > weight) {
            percent = 842 / height * 100;
        } else {
            percent = 530 / weight * 100;
        }
        return Math.round(percent);
    }

    /**
     * 第二种解决方案，统一按照宽度压缩 这样来的效果是，所有图片的宽度是相等的，自我认为给客户的效果是最好的
     *
     * @param weight
     */
    public int getPercentByWeight(float weight) {
        float percent = 530 / weight * 100;
        return Math.round(percent);
    }
}
