package test.poi;

import java.util.ArrayList;
import java.util.List;

import util.poi.PoiExcelExport;

public class PoiExcelExportTest {

	public static void main(String[] args) {
		PoiExcelExport pee = new PoiExcelExport("E:/test.xls","sheet");
		//数据
        List<Man> dataList = new ArrayList();
        for(int i=0;i<100000;i++){
        	Man man = new Man("人"+i,21,"男",(float)11000.8);
        	dataList.add(man);
        }
     
        //调用
        String titleColumn[] = {"name","sex","idCard","salary",""};
        String titleName[] = {"姓名","性别","身份证号","月薪","年薪"};
        int titleSize[] = {13,13,13,13,13};
        //其他设置 set方法可全不调用
        String colFormula[] = new String[5];
        colFormula[4] = "D@*12";   //设置第5列的公式
        pee.setColFormula(colFormula);
        pee.setAddress("A:D");  //自动筛选 
        //设置每个sheet最大显示行数
        pee.setSheetSize(50000);
        pee.wirteExcel(titleColumn, titleName, titleSize, dataList);
      
	}

}
