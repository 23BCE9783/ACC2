import java.util.*;

class Main {
    static void Span(int a[], int s[], int n) {
        Stack<Integer> st = new Stack<>();
        s[0] = 1;
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && a[i] > a[st.peek()]) {
                st.pop();
            }
            s[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String arf[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int s[] = new int[n];
        Span(a, s, n);
        sc.close();
    }
}


// Stock Span Brute force
// SLL Swap the adjacent nodes
// Make a PDF and Mail before 11pm