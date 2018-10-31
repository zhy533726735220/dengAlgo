import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class A{

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {

        // ================= 代码实现开始 =================

        /* 请在这里定义你需要的全局变量 */
        List<Node> leafNodes = new ArrayList<>();
        // 这是求解整个问题的函数
        // w：题目描述中的 w（所有）
        // n：题目描述中的 n
        // 返回值：答案
        long getAnswer(int n, List<Long> w) {
            /* 请在这里设计你的算法 */
            long ans = 0;
            HuffmanTree tree = new HuffmanTree();
            tree.createHfmTree(w, leafNodes);
            tree.buildEncodingInfo(leafNodes);
            // 计算
            for (Node leaf:leafNodes){
                ans += leaf.code.length() * leaf.weight;
            }
            return ans;
        }

        private class Node implements Comparable<Node>{
            String code = ""; // 节点的哈夫曼编码
            Long weight = 0L; // 节点的权值, 频数
            Node parent = null;
            Node leftChild = null;
            Node rightChild = null;

            boolean isLeftChild() {
                return parent != null && this == parent.leftChild;
            }

            @Override
            public int compareTo(Node o) {
                if (weight == o.weight){
                    return 0;
                } else if (weight > o.weight){
                    return 1;
                } else {
                    return -1;
                }
            }
        }

        private class HuffmanTree{
            Node root; // 根节点

            void createHfmTree(List<Long> w, List<Node> leafs){
                PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
                for (Long v : w){
                    Node node = new Node();
                    node.weight = v;
                    priorityQueue.add(node);
                    leafs.add(node);
                }

                int n = w.size();
                while (n > 1){
                    // 取出最小的两个
                    Node node1 = priorityQueue.poll();
                    Node node2 = priorityQueue.poll();

                    Node sumNode = new Node();
                    sumNode.weight = node1.weight + node2.weight;
                    sumNode.leftChild = node1;
                    sumNode.rightChild = node2;

                    node1.parent = sumNode;
                    node2.parent = sumNode;

                    priorityQueue.add(sumNode);
                    n--;
                }
                this.root = priorityQueue.poll();
            }

            void buildEncodingInfo(List<Node> leafNodes){
                for (Node leafNode : leafNodes){
                    String code = "";
                    Node currentNode = leafNode;
                    do{
                        if (currentNode.isLeftChild()){
                            code = "0" + code;
                        } else {
                            code = "1" + code;
                        }
                        currentNode = currentNode.parent;
                    } while (currentNode.parent != null);
                    leafNode.code = code;
                }
            }
        }

        // ================= 代码实现结束 =================

        void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            List<Long> w = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                long x = in.nextLong();
                w.add(x);
            }
            out.println(getAnswer(n, w));
        }

    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        private InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        private String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        private short nextShort() {
            return Short.parseShort(next());
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private float nextFloat() {
            return Float.parseFloat(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }
    }

}