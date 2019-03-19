import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FileHandler {
	private final static String IndexFileName = "PrimaryIndex.bin";
	private final static String DataFileName = "SampleDataFile.bin";
	private int data_file_size = 0;
	private static int index_file_size = 0;
	private static int data_file_eof = 0;
	private int index_file_eof = 0;

	FileHandler() throws IOException {
		RandomAccessFile data_file = new RandomAccessFile(DataFileName, "r");
		RandomAccessFile index_file = new RandomAccessFile(IndexFileName, "rw");

		this.data_file_size = (int) data_file.length();
		data_file.seek(data_file_size);
		FileHandler.data_file_eof = (int) data_file.getFilePointer();

		FileHandler.index_file_size = (int) index_file.length();
		index_file.seek(index_file_size);
		this.index_file_eof = (int) index_file.getFilePointer();

		data_file.close();
		index_file.close();
	}
	private void updateMetaData() throws IOException
	{
		RandomAccessFile data_file = new RandomAccessFile(DataFileName, "r");
		RandomAccessFile index_file = new RandomAccessFile(IndexFileName, "rw");

		this.data_file_size = (int) data_file.length();
		data_file.seek(data_file_size);
		FileHandler.data_file_eof = (int) data_file.getFilePointer();

		FileHandler.index_file_size = (int) index_file.length();
		index_file.seek(index_file_size);
		this.index_file_eof = (int) index_file.getFilePointer();

		data_file.close();
		index_file.close();
		
	}
	public void constructIndexFile() throws IOException {
		long pointer = 0;
		Product product = new Product();
		Index index = new Index();
		Map<Integer, Integer> map = new HashMap<>();
		while (pointer != data_file_eof) {
			product.readProduct(pointer);
			pointer = pointer + 12;
			map.put(product.getId(), product.getOffset());
		}
		Map<Integer, Integer> indexMap = new TreeMap<Integer, Integer>(map);
		System.out.println(indexMap);
		pointer = 0;
		
		for (Map.Entry<Integer, Integer> entry : indexMap.entrySet()) {
			
			index.setProduct_id(entry.getKey());
			index.setOffset(entry.getValue());
			index.writeIndex(pointer);
			pointer = pointer + 8;
		}
		Index.readAllIndex();

	}
	public Product searchProduct(int p_id) throws IOException
	{
		Product p = new Product();
		int offset = Index.binarySearch(p_id);
		p.readProduct(offset);
		
		return p;
	}
	public void addProduct(Product p) throws IOException
	{
		Product.writeRandomProduct(p);
		int pointer = 0;
		Index curr = new Index();
		Index new_ = new Index();
		new_.setProduct_id(p.getId());
		new_.setOffset(p.getOffset());
		while(pointer != index_file_eof)
		{
			curr.readIndex(pointer);
			if(curr.getProduct_id() > new_.getProduct_id())
			{
				new_.writeIndex(pointer);
				new_.setProduct_id(curr.getProduct_id());
				new_.setOffset(curr.getOffset());
			}
			pointer = pointer + 8;
		}
		new_.writeIndex(pointer);
		updateMetaData();
	}
	public void deleteProduct(Product p) throws IOException
	{
		
	}
	  
}
