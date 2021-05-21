package updateFile;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Exel_DAO extends PngFile{
	GetTime gt = new GetTime();
	public void copyFolder(File sourceFolder, File targetFolder) 
            throws IOException {
		String PngName;
		
        if (sourceFolder.isDirectory()) {
            String files[] = sourceFolder.list(new PngFile());

            if(!targetFolder.exists()) {
            	targetFolder.mkdirs();
            	System.out.println("Folder da duoc tao " + targetFolder);
            }
            for (String file : files) {
                File srcFile = new File(sourceFolder, file);
                PngName = ("Ngay-"+gt.getDayNow()+" "+gt.getHourNow()+"h"+gt.getMinNow()+"m"+gt.getSecNow()+"s"+".png"); 
                
                File tarFile = new File(targetFolder, PngName);
               
                copyFolder(srcFile, tarFile);
                srcFile.delete();
            }
        } else {
            Files.copy(sourceFolder.toPath(), targetFolder.toPath(), 
                    StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File da duoc copy " + targetFolder);
        }
    }
	
    public List<Exel_Data> listTest_Exel_Datas() throws IOException {
        List<Exel_Data> list = new ArrayList<Exel_Data>();
        
        String target = "C:\\"+gt.getTimeNow();
        
        File sourceFolder = new File("D:\\Test");
        File targetFolder = new File(target);
        
        copyFolder(sourceFolder, targetFolder);
        
        String files[] = targetFolder.list(new PngFile());
        int i = 1;
        for (String file : files) {
        	Exel_Data e = new Exel_Data(i, target+"\\"+file);
            list.add(e);
            i++;
        }

        return list;
    }
}



