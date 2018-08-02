package wenxiong.string.pattern.search.kmp;

public class Kmp {

	public static void main(String[] args) {
		String str = "abbabbabab";
		String pattern = "aba";
		int index = searchIndexOf(str, pattern);
		if (index > 0) {
			System.out.println("-------------------");
			System.out.println("找到结果，index="  + index + " : " + str.substring(index, index + pattern.length()));
		}
	}
	
	private static int searchIndexOf(String str, String pattern) {
		int next[] = getNext(pattern);
		int size = str.length();
		int i = 0;
		int j = 0;
		while(i < size && j < pattern.length()){
			if (j ==-1 || str.charAt(i) == pattern.charAt(j)) {
				if (j == -1) {
					System.out.println("-------------------");
					System.out.println("向前移位,i：" + (i+ 1) + ",j:" + (j + 1)
							);
				}else{
					System.out.println("匹配成功,"
							+ "str[" + i + "]:" + str.charAt(i) + ",p[" + j +"]:" + pattern.charAt(j));
				}
				i++;
				j++;
			}else{
				System.out.println("不相等,"
						+ "str[" + i + "]:" + str.charAt(i) + ",p[" + j +"]:" + pattern.charAt(j)
						+"。回溯,j=" + next[j]);
				j = next[j];
			}
			
		}
		return j >= pattern.length() ? i - pattern.length() : 0;
	}

	public static int[] getNext(String patter){
		int size = patter.length();
		byte[] ch = patter.getBytes();
		int next[] = new int[size+1];
		int i = 0;
		int j = -1;
		next[i] = j;
		while(i < size){
			if(j == -1 || ch[j] == ch[i]){
				++j;
				++i;
				next[i] = j;
			}else { 
				j = next[j];
			}
		}
		System.out.print("[");
		for (int n : next) {
			System.out.print(" " + n);
		}
		System.out.println("]");
		return next;
	}
}
