import java.util.Arrays;

public class pg_12915 {

	public String[] solution(String[] strings, int n) {
		Word[] words = new Word[strings.length];

		for (int i = 0; i < strings.length; i++) {
			words[i] = new Word(strings[i], n);
		}
		Arrays.sort(words);

		String[] answer = new String[strings.length];
		for (int i = 0; i < strings.length; i++) {
			answer[i] = words[i].word;
		}
		return answer;
	}

}

class Word implements Comparable<Word> {

	String word;
	int index;

	public Word(String word, int index) {
		this.word = word;
		this.index = index;
	}

	@Override
	public int compareTo(Word o) {
		if (this.word.charAt(this.index) > o.word.charAt(o.index)) {
			return 1;
		} else if (this.word.charAt(this.index) < o.word.charAt(o.index)) {
			return -1;
		} else {
			return this.word.compareTo(o.word);
		}
	}
}
