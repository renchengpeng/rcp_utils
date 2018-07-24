import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.bee.sys.utils.CSVUtils;

/**
 * 
 */

/**
 * @author "john.lh"
 * @Date 2015-9-9 上午11:02:22
 */
public class CSVUtilsTest {
	/**
	 * CSV导出
	 * 
	 * @throws Exception
	 */
	public static void exportCsv() {
		List<String> dataList = new ArrayList<String>();
		dataList.add("1,张三,男");
		dataList.add("2,李四,男");
		dataList.add("3,小红,女");
		boolean isSuccess = CSVUtils.exportCsv(new File(
				"C:/Users/john/Desktop/test.csv"), dataList);
		System.out.println(isSuccess);
	}

	/**
	 * CSV导出
	 * 
	 * @throws Exception
	 */
	public static void importCsv() {
		List<String> dataList = CSVUtils.importCsv(new File(
				"C:/Users/john/Desktop/test.csv"));
		if (dataList != null && !dataList.isEmpty()) {
			for (String data : dataList) {
				System.out.println(data);
			}
		}
	}

	public static void main(String[] args) {
		exportCsv();
		importCsv();

	}
}
