package personal.jain.akash.sort.testdata;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestDataReader {

	private List<ISingleTestData<Integer>> testsList;
	
	public TestDataReader(String filename) throws JsonParseException, JsonMappingException, IOException {
		testsList = 
				new ObjectMapper().readValue(fetchFile(filename), new TypeReference<List<IntegerSingleTestData>>() {});
	}
	
	public List<ISingleTestData<Integer>> getTestsList() {
		return testsList;
	}
	
	private static File fetchFile(String in_filePath) {
        URL l_resourceUrl = Thread.currentThread().getContextClassLoader()
                .getResource(in_filePath);
        
        if (l_resourceUrl == null) {
            return new File(in_filePath);
        }
        
        try {
            l_resourceUrl = decodeURLPath(l_resourceUrl);
        } catch (MalformedURLException e) {
        }

        

        return new File(l_resourceUrl.getFile());
    }
	
	private static String decodeURLPath(String in_string) {
        String lr_decodedString = "";
        try {
            lr_decodedString = URLDecoder.decode(in_string, "UTF-8");
        } catch (UnsupportedEncodingException e) {

        }
        return lr_decodedString;
    }

	private static URL decodeURLPath(URL in_url) throws MalformedURLException {
        
        return new URL(decodeURLPath(in_url.toString()));
    }
}
