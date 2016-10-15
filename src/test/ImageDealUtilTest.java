package test;

import util.ImageDealUtil;

public class ImageDealUtilTest {

	public static void main(String[] args) {
		ImageDealUtil imageDeal = new ImageDealUtil("e://1.png", "e://", "2", "png");
        // 测试缩放
      /*  try {
			imageDeal.zoom(200, 300);
		} catch (Exception e2) {
			e2.printStackTrace();
		} */
        // 测试旋转
       /*  try {
			imageDeal.spin(90);
		} catch (Exception e1) {
			e1.printStackTrace();
		}*/ 
        //测试马赛克
       /* try {
			imageDeal.mosaic(4);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
