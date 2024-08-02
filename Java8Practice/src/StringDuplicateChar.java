import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringDuplicateChar {
	public static void main(String[] args) {
		String input = "JavaJavaEEqqff";
		Map<String, Long> map= new HashMap<>();
		map = input.chars().mapToObj(a->(char)a).collect(Collectors.groupingBy(Object::toString,Collectors.counting()));
		map.entrySet().stream().filter(s->s.getValue()>1).map(Map.Entry::getKey).forEach(System.out::println);
		
		//another way
		char[] c = input.toLowerCase().toCharArray();
		Map<Character, Long> duplicateChar = new HashMap<Character, Long>();
		
		for(Character c1 : c) {
			if(duplicateChar.containsKey(c1)) {
				duplicateChar.put(c1, duplicateChar.get(c1)+1);
			}else {
				duplicateChar.put(c1, 1L);
			}
		}
		List<Character> s = duplicateChar.entrySet().stream().filter(m->m.getValue()>1).map(Map.Entry::getKey).sorted().collect(Collectors.toList());
		System.out.println(s);
	}
}