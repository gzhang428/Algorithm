package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {

	public static void main(String[] args) {
		new SimplifyPath().simplifyPath("/...");
	}
	 public String simplifyPath(String path) {
	        List<String> list = new ArrayList<>();
	        String[] names = path.split("\\/+");
	        
	        for (String name: names){
	            if (name.equals(".") || name.equals("")){
	                
	            } else if (name.equals("..")){
	                if (list.size() > 0){
	                    list.remove(list.size() - 1);
	                }
	            } else {
	                list.add(name);
	            }
	            
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        if (list.isEmpty()){
	            sb.append("/");
	        } else {
	            for (String name: list){
	                sb.append("/");
	                sb.append(name);
	            }
	        }

	        return sb.toString();
	    }
}
