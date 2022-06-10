package th.co.interview.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment {

	public static void main(String[] args) throws IOException {
		//1.1 �ӹǳ�źǡ ź �ٳ ���(div) ���(mod) �ͧ�Ţ 1.234567 ��� 7.653421 ���� BigDecimal ����ʴ������Ţ�ȹ��� 2 ��ѡ
		System.out.println("1.1 �ӹǳ�źǡ ź �ٳ ���(div) ���(mod) �ͧ�Ţ 1.234567 ��� 7.653421 ���� BigDecimal ����ʴ������Ţ�ȹ��� 2 ��ѡ");
		BigDecimal dbNumber1 = new BigDecimal("1.234567");
        BigDecimal dbNumber2 = new BigDecimal("7.653421");
        doBigDecimal(dbNumber1, dbNumber2);
        
        //1.2 ����Ҥ���ᵡ��ҧ�����ҧ�ѹ��� 2 ���Ҥ� 2563 ���� 10:59 �. �Ѻ�ѹ��� 30 �ѹ�Ҥ� 2562 ���� 11:15 �. �����ҧ�ѹ�������ѹ ��������� ���ҷ� ����Թҷ�
        System.out.println("1.2 ����Ҥ���ᵡ��ҧ�����ҧ�ѹ��� 2 ���Ҥ� 2563 ���� 10:59 �. �Ѻ�ѹ��� 30 �ѹ�Ҥ� 2562 ���� 11:15 �. �����ҧ�ѹ�������ѹ ��������� ���ҷ� ����Թҷ�");
        String start_date = "30-12-2562 11:15:00";
        String end_date = "02-01-2563 10:59:00";
        doDateDifference(start_date, end_date);
        
        //1.3 ����Ҽ�����ͧ�ӹǹ�����ô��� 7 ŧ��� ������������ҧ 1 �֧ 1000 ���ʴ����Ѿ����ٻẺ a + b + c + ... = X �� a b c ... ���§�ӴѺ�ҡ������ҡ
        System.out.println("1.3 ����Ҽ�����ͧ�ӹǹ�����ô��� 7 ŧ��� ������������ҧ 1 �֧ 1000 ���ʴ����Ѿ����ٻẺ a + b + c + ... = X �� a b c ... ���§�ӴѺ�ҡ������ҡ");
        int start_number = 1;
        int end_number = 1000;
        doCalculate(start_number, end_number);
        
        //1.4 �����ҹ�����Ũҡ��� input.txt ���ǹӵ���Ţ����ӡѹ�������͡� �ʴ����Ѿ��������ӡѹ������� output.txt �����§�ӴѺ�ҡ�ҡ仹��� (��� input.txt ������Ṻ)
        System.out.println("1.4 �����ҹ�����Ũҡ��� input.txt ���ǹӵ���Ţ����ӡѹ�������͡� �ʴ����Ѿ��������ӡѹ������� output.txt �����§�ӴѺ�ҡ�ҡ仹��� (��� input.txt ������Ṻ)");
        doCreateFile();

	}

	public static void doBigDecimal(BigDecimal dbNumber1, BigDecimal dbNumber2) {

		try {

			BigDecimal bdAdd = dbNumber1.add(dbNumber2);// Operation Add (+)
			BigDecimal bdSubtract = dbNumber1.subtract(dbNumber2); // Operation Subtract (-)
			BigDecimal bdMultiply = dbNumber1.multiply(dbNumber2); // Operation Multiply (*)
			BigDecimal bdDivide = dbNumber1.divide(dbNumber2, 2, RoundingMode.HALF_UP); // Operation Divide (div)
			BigDecimal bdRemainder = dbNumber1.remainder(dbNumber2);// Operation Remainder (mod)
			
			System.out.println(bdRoundHalfUp(bdAdd));
			System.out.println(bdRoundHalfUp(bdSubtract));
			System.out.println(bdRoundHalfUp(bdMultiply));
			System.out.println(bdRoundHalfUp(bdDivide));
			System.out.println(bdRoundHalfUp(bdRemainder));

		} catch (Exception e) {
			System.out.println(e);

		}
	}
	
	
	public static void doDateDifference(String start_date, String end_date) {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		try {
			Date dateFrom = dateformat.parse(start_date);
			Date dateTo = dateformat.parse(end_date);

			long differenceTime = dateTo.getTime() - dateFrom.getTime();

			long differenceDays = (differenceTime / (1000 * 60 * 60 * 24) % 365);
			long differenceHours = (differenceTime / (1000 * 60 * 60) % 24);
			long differenceMinutes = (differenceTime / (1000 * 60) % 60);
			long differenceSecound = (differenceTime / (1000 ) % 60);
			System.out.println("Difference is : " 
								+ differenceDays + " Days "
								+ differenceHours + " Hours "  
								+ differenceMinutes + " Minutes "
								+ differenceSecound + " Secound ");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static void doCalculate(int start_number, int end_number) {
		ArrayList<Integer> numberList = new ArrayList<Integer>();

		for (int r = start_number; r <= end_number; r++) {

			if (r % 7 == 0)
				numberList.add(r);

		}

		long sumNumber = numberList.stream().mapToLong(Integer::longValue).sum();
		String listNumbers = numberList.stream().map(Object::toString).collect(Collectors.joining("+"));

		System.out.println(listNumbers + " = " + sumNumber);
	}
	
	public static void doCreateFile() throws IOException {

		File inputFile = new File("input/input.txt");
		File outputFile = new File("output/output.txt");
		ArrayList<String> strNumberList = new ArrayList<String>();
		List<Double> sortNumberList = new ArrayList<Double>();

		try {
			try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
				String line;
				while ((line = br.readLine()) != null) {
					line = line.trim();
					if (!strNumberList.contains(line) && !line.equals("")) {
						strNumberList.add(line);
						sortNumberList.add((double) Integer.parseInt(line));
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			Collections.sort(sortNumberList);
			FileOutputStream fileOS = new FileOutputStream(outputFile);
			OutputStreamWriter writeFile = new OutputStreamWriter(fileOS);

			for (Double number : sortNumberList) {
				writeFile.write(number.intValue() + "\n");
			}

			writeFile.close();
			System.out.println("Result : output/output.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static BigDecimal bdRoundHalfUp(BigDecimal dbNumber) {
		dbNumber = dbNumber.setScale(2, BigDecimal.ROUND_HALF_UP);
		return dbNumber;
	}
	
}
