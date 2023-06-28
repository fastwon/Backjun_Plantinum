import java.util.Scanner;

public class MaxRectangular_plati5 {
	static int[] hgram;
	
	static long divideGram(int start, int end) {
		if(end - start == 0) return hgram[end];
		
		int mid = (end + start) / 2;
		
		long area = Math.max(divideGram(start, mid), divideGram(mid+1, end));
		
		area = Math.max(area, midGram(start, end, mid));
		
		return area;
	}
	
	static long midGram(int start, int end, int mid) {
		long area = hgram[mid];
		
		long height = hgram[mid];
		int left = mid;
		int right = mid;
		
		while(start < left && right < end) {
			if(hgram[left-1] < hgram[right+1]) {
				right++;
				height = Math.min(hgram[right], height);
			} else {
				left--;
				height = Math.min(hgram[left], height);
			}
			
			area = Math.max(area, (right - left + 1) * height);
			
		}
		
		while(start < left) {
			left--;
			height = Math.min(hgram[left], height);
			area = Math.max(area, (right - left + 1) * height);
		}
		
		while(right < end) {
			right++;
			height = Math.min(hgram[right], height);
			area = Math.max(area, (right - left + 1) * height);
		}
		
		return area;
	}
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	StringBuilder sb = new StringBuilder();
    	
    	int N;
    	
    	while(true) {
    		N = sc.nextInt();
    		
    		if(N == 0) break;
    		
    		hgram = new int[N];
    		
    		for(int i=0; i<N; i++) {
    			hgram[i] = sc.nextInt();
    		}
    		
    		sb.append(divideGram(0, N-1) + "\n");
    	}
    	
    	System.out.println(sb);
    }
}

