package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * ͼ������.
 * @author nagsh
 * @version 1.0
 */
public class ImageDealUtil {

    String openUrl; // ԭʼͼƬ��·��
    String saveUrl; // ��ͼ����·��
    String saveName; // ��ͼ����
    String suffix; // ��ͼ���� ֻ֧��gif,jpg,png
    /**
     * 
     * @param openUrl ԭʼͼƬ��·��.
     * @param saveUrl ��ͼ����·��.
     * @param saveName ��ͼ����.
     * @param suffix ��ͼ���� ֻ֧��gif,jpg,png.
     */
    public ImageDealUtil(String openUrl, String saveUrl, String saveName,
            String suffix) {
        this.openUrl = openUrl;
        this.saveName = saveName;
        this.saveUrl = saveUrl;
        this.suffix = suffix;
    }

    /**
     * ͼƬ����.
     * 
     * @param width
     *            ��Ҫ�Ŀ��.
     * @param height
     *            ��Ҫ�ĸ߶�.
     * @throws Exception
     */
    public void zoom(int width, int height) throws Exception {
        double sx = 0.0;
        double sy = 0.0;

        File file = new File(openUrl);
        if (!file.isFile()) {
            throw new Exception("ImageDeal>>>" + file + " ����һ��ͼƬ�ļ�!");
        }
        BufferedImage bi = ImageIO.read(file); // ��ȡ��ͼƬ
        // ����x��y�����ű���--����ȱ������ţ��ڵ���֮ǰȷ������width��height�ǵȱ����仯��
        sx = (double) width / bi.getWidth();
        sy = (double) height / bi.getHeight();

        AffineTransformOp op = new AffineTransformOp(
                AffineTransform.getScaleInstance(sx, sy), null);
        File sf = new File(saveUrl, saveName + "." + suffix);
        Image zoomImage = op.filter(bi, null);
        try {
            ImageIO.write((BufferedImage) zoomImage, suffix, sf); // ����ͼƬ
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * ��ת
     * 
     * @param degree
     *            ��ת�Ƕ�.
     * @throws Exception
     */
    public void spin(int degree) throws Exception {
        int swidth = 0; // ��ת��Ŀ��
        int sheight = 0; // ��ת��ĸ߶�
        int x; // ԭ�������
        int y; // ԭ��������

        File file = new File(openUrl);
        if (!file.isFile()) {
            throw new Exception("ImageDeal>>>" + file + " ����һ��ͼƬ�ļ�!");
        }
        BufferedImage bi = ImageIO.read(file); // ��ȡ��ͼƬ
        // ����Ƕ�--ȷ����ת����
        degree = degree % 360;
        if (degree < 0)
            degree = 360 + degree;// ���Ƕ�ת����0-360��֮��
        double theta = Math.toRadians(degree);// ���Ƕ�תΪ����

        // ȷ����ת��Ŀ�͸�
        if (degree == 180 || degree == 0 || degree == 360) {
            swidth = bi.getWidth();
            sheight = bi.getHeight();
        } else if (degree == 90 || degree == 270) {
            sheight = bi.getWidth();
            swidth = bi.getHeight();
        } else {
            swidth = (int) (Math.sqrt(bi.getWidth() * bi.getWidth()
                    + bi.getHeight() * bi.getHeight()));
            sheight = (int) (Math.sqrt(bi.getWidth() * bi.getWidth()
                    + bi.getHeight() * bi.getHeight()));
        }

        x = (swidth / 2) - (bi.getWidth() / 2);// ȷ��ԭ������
        y = (sheight / 2) - (bi.getHeight() / 2);

        BufferedImage spinImage = new BufferedImage(swidth, sheight,
                bi.getType());
        // ����ͼƬ������ɫ
        Graphics2D gs = (Graphics2D) spinImage.getGraphics();
        gs.setColor(Color.white);
        gs.fillRect(0, 0, swidth, sheight);// �Ը�����ɫ������ת��ͼƬ�ı���

        AffineTransform at = new AffineTransform();
        at.rotate(theta, swidth / 2, sheight / 2);// ��תͼ��
        at.translate(x, y);
        AffineTransformOp op = new AffineTransformOp(at,
                AffineTransformOp.TYPE_BICUBIC);
        spinImage = op.filter(bi, spinImage);
        File sf = new File(saveUrl, saveName + "." + suffix);
        ImageIO.write(spinImage, suffix, sf); // ����ͼƬ

    }
    /**
     * �����˻�.
     * @param size  �����˳ߴ磬��ÿ�����εĳ���.
     * @return  �Ƿ�ɹ�
     * @throws Exception
     */
    public boolean mosaic(int size) throws Exception {
        File file = new File(openUrl);
        if (!file.isFile()) {
            throw new Exception("ImageDeal>>>" + file + " ����һ��ͼƬ�ļ�!");
        }
        BufferedImage bi = ImageIO.read(file); // ��ȡ��ͼƬ
        BufferedImage spinImage = new BufferedImage(bi.getWidth(),
                bi.getHeight(), bi.TYPE_INT_RGB);
        if (bi.getWidth() < size || bi.getHeight() < size || size <= 0) { // �����˸�ߴ�̫���̫С
            return false;
        }

        int xcount = 0; // ������Ƹ���
        int ycount = 0; // y������Ƹ���
        if (bi.getWidth() % size == 0) {
            xcount = bi.getWidth() / size;
        } else {
            xcount = bi.getWidth() / size + 1;
        }
        if (bi.getHeight() % size == 0) {
            ycount = bi.getHeight() / size;
        } else {
            ycount = bi.getHeight() / size + 1;
        }
        int x = 0;   //����
        int y = 0;
        // ����������(���ƾ��β������ɫ)
        Graphics gs = spinImage.getGraphics();
        for (int i = 0; i < xcount; i++) {
            for (int j = 0; j < ycount; j++) {
                //�����˾��θ��С
                 int mwidth = size;
                 int mheight = size;
                 if(i==xcount-1){   //�������һ���Ƚ����⣬���ܲ���һ��size
                     mwidth = bi.getWidth()-x;
                 }
                 if(j == ycount-1){  //ͬ��
                     mheight =bi.getHeight()-y;
                 }
              // ������ɫȡ�������ص�RGBֵ
                int centerX = x;
                int centerY = y;
                if (mwidth % 2 == 0) {
                    centerX += mwidth / 2;
                } else {
                    centerX += (mwidth - 1) / 2;
                }
                if (mheight % 2 == 0) {
                    centerY += mheight / 2;
                } else {
                    centerY += (mheight - 1) / 2;
                }
                Color color = new Color(bi.getRGB(centerX, centerY));
                gs.setColor(color);
                gs.fillRect(x, y, mwidth, mheight);
                y = y + size;// ������һ�����ε�y����
            }
            y = 0;// ��ԭy����
            x = x + size;// ����x����
        }
        gs.dispose();
        File sf = new File(saveUrl, saveName + "." + suffix);
        ImageIO.write(spinImage, suffix, sf); // ����ͼƬ
        return true;
    }

}
