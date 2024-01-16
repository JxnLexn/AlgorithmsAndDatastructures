package Scheinaufgaben.set06;

import java.util.Random;

public class Document implements Comparable<Document> 
{
	private String id; //key = 8 digit document ID, leading zeros possible
	private String title; 
	
	public static final int ID_LENGTH = 8;
	
	public Document(String title, String id) {
		this.title = title;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public String toString() {
		return "id " + id + ": " + title; 
	}
	
	/**Sort an array of document using radix sort.	 */
	public static void documentSort(Document[] dlist) {
		for (int digit = ID_LENGTH - 1; digit >= 0; digit--) {
			radixSingleSort(dlist, digit);
		}
	}

	private static void radixSingleSort(Document[] dlist, int digitIndex) {
		final int radix = 10;
		int itemCount = dlist.length;
		int[] countArray = new int[radix];

		for (Document doc : dlist) {
			countArray[getDigitAtIndex(doc.getId(), digitIndex)]++;
		}

		for (int j = 1; j < radix; j++) {
			countArray[j] += countArray[j - 1];
		}

		Document[] temp = new Document[itemCount];
		for (int tempIndex = itemCount - 1; tempIndex >= 0; tempIndex--) {
			temp[--countArray[getDigitAtIndex(dlist[tempIndex].getId(), digitIndex)]] = dlist[tempIndex];
		}

		System.arraycopy(temp, 0, dlist, 0, itemCount);
	}

	private static int getDigitAtIndex(String id, int index) {
		return id.charAt(index) - '0';
	}



	@Override
	public int compareTo(Document other) {
		return id.compareTo(other.id);
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Document) {	
			return id == ((Document)other).id;
		} else {
			return false;
		}
	}
	
	
	
	/** generates randomly an array containing the specified number of documents with random id numbers */
	public static Document[] generateDocumentList(int size) {
		Document[] list = new Document[size];
		
		Random rand = new Random();
		
		for (int i = 0; i < list.length; i++) {
			String title = "S_" + i;
			//generate random ID
			int did = rand.nextInt(90000000);
			did+=10000000;
			String matnrStr = Integer.toString(did);
			
			list[i] = new Document(title, matnrStr);
		}
		
		return list;
	}
	
	


	
}
