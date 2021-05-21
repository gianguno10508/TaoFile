package updateFile;

import java.io.File;
import java.io.FilenameFilter;

class PngFile implements FilenameFilter {
	 
    @Override
    public boolean accept(File dir, String name) {
 
        if (name.endsWith(".png")) {
            return true;
        }
 
        return false;
    }
 
}
