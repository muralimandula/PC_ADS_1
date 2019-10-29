final class Solution {

	public static String isMatching(String str){
		// fill you code Here

		String[] braces = str.split("");

		String[] stack = new String[str.length()];
		
        int size = 0;
        
        for (int i = 0; i < braces.length; i++) {

			// for every open parenthesis, pushing into stack (of Array[])
            if (braces[i].equals("{") || braces[i].equals("[") || braces[i].equals("(")) {
				
				stack[size++] = braces[i];
			
			// in case of closing parenthisis, checking the last in stack and removing (size--)

            } else if (size > 0) { // validation must have parenthesis

                if (braces[i].equals("}") && stack[size - 1].equals("{")) {
                    size--;

				} else if (braces[i].equals("]") && stack[size - 1].equals("[")) {
					size--;
					
                 } else if (braces[i].equals(")") && stack[size - 1].equals("(")) {
                    size--;
                }
            }
		}
		
		// above for loop balances every opening-closing pair
		// expects zero for balanced one
		
        if (size == 0) {
            return "YES";
        } else {
            return "NO";
        }
	}
}