import java.util.*;

public class AddressBook	{

	private HashMap<String, Record> mapRecords;
	private ArrayList<String> namesList;	//For ordering list as HashMap is unordered
	
	private int curRecordIndex = 0;
	private Record curRecrod;
	
	AddressBook()	{
		namesList = new ArrayList<String>();
		mapRecords = new HashMap<String, Record>();
	}
	
	public Record first()	{

		curRecordIndex = 0;
		return getCurRecord();
	}
	
	public Record last()	{

		curRecordIndex = namesList.size() - 1;
		return getCurRecord();
	}
	
	public Record next()	{

		curRecordIndex++;
		if (curRecordIndex >= namesList.size())
			curRecordIndex = namesList.size() - 1;
		
		return getCurRecord();
	}
	
	public Record previous()	{

		curRecordIndex--;
		if (curRecordIndex<0)
			curRecordIndex = 0;
		
		return getCurRecord();
	}
	
	public Record get(String name)	{
		curRecordIndex = namesList.indexOf(name);
		return getCurRecord();
	}

	public Record getCurRecord()	{
	
		Record rec = null;
		String name = null;
		
		if (curRecordIndex>=0 && curRecordIndex < namesList.size())
			name = namesList.get(curRecordIndex);
		
		if (name!=null)
			rec = mapRecords.get(name);
		
		return rec;
	}
	
	public Record addRecord(String name, String address, String phoneNumber) {

			Record rec = new Record(name, address, phoneNumber);
			mapRecords.put(name, rec);
			namesList.add(name);
			
			curRecordIndex = namesList.indexOf(name);
			
			return rec;
	}
	
	public void remove(String name)	{
	
		Record r = get(name);
		
		mapRecords.remove(name);
		namesList.remove(name);
		
		curRecordIndex--;
		if (curRecordIndex<0)
			curRecordIndex = 0;
	}
	
	
}