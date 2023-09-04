
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPerfume = scanner.nextInt();
        int countQuestions = scanner.nextInt();

        List<Question> questions = new ArrayList<>();
        for (int i = 1; i <= countQuestions; i++) {
            int type = scanner.nextInt();
            int x = scanner.nextInt();
            if (type == 3) {
                questions.add(new Question(type, x));
            } else {
                int y = scanner.nextInt();
                questions.add(new Question(type, x, y));
            }
        }

        List<List<Spirit>> perfume = new ArrayList<>();
        for (Question q : questions) {
            if (q.type == 1) question1(perfume, q);
            if (q.type == 2) question2(perfume, q);
            if (q.type == 3) question3(perfume, q);
        }
    }

    public static void question1(List<List<Spirit>> perfume, Question q) {
        if (perfume.isEmpty()) {
            perfume.add(new ArrayList<>(List.of(new Spirit(q.x), new Spirit(q.y))));
            return;
        }
        for (List<Spirit> band : perfume) {
            if (checkingOneBand(band, q.x, q.y)) return;
            for (int i = 0, j = band.size()-1; i < band.size() && j > 0; i++, j--) {
                if (band.get(i).number == q.x || band.get(j).number == q.x) {
                    increaseLike(band);
                    band.add(new Spirit(q.y));
                    return;
                }
                if (band.get(i).number == q.y || band.get(j).number == q.y) {
                    increaseLike(band);
                    band.add(new Spirit(q.x));
                    return;
                }
            }
        }
        perfume.add(new ArrayList<>(List.of(new Spirit(q.x), new Spirit(q.y))));
    }

    public static void question2(List<List<Spirit>> perfume, Question q) {
        if (q.x == q.y) {
            System.out.println("YES");
            return;
        }
        for (List<Spirit> band : perfume) {
            if (checkingOneBand(band, q.x, q.y)) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    public static void question3(List<List<Spirit>> perfume, Question q) {
        for (List<Spirit> band : perfume) {
            for (int i = 0, j = band.size()-1; i < band.size() && j > 0; i++, j--) {
                if (band.get(i).number == q.x) {
                    System.out.println(band.get(i).likeBand);
                    return;
                }
                if (band.get(j).number == q.x) {
                    System.out.println(band.get(j).likeBand);
                    return;
                }
            }
        }
        System.out.println(1);
    }

    public static boolean checkingOneBand(List<Spirit> band, int x, int y) {
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0, j = band.size()-1; i < band.size() && j > 0; i++, j--) {
            if (flag1 && flag2) return true;
            if (!flag1 && band.get(i).number == x || band.get(i).number == y) flag1 = true;
            if (!flag2 && band.get(j).number == x || band.get(j).number == y) flag2 = true;
        }
        return false;
    }

    public static void increaseLike(List<Spirit> band) {
        for (int i = 0, j = band.size()-1; i < band.size() && j > 0; i++, j--) {
            band.get(i).likeBand++;
            band.get(j).likeBand++;
            if (i == j) return;
        }
    }
    static class Question {
        int type;
        int x;
        int y;

        public Question(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
        public Question(int type, int x) {
            this.type = type;
            this.x = x;
        }
    }
    static class Spirit {
        int number;
        int likeBand;

        public Spirit(int number) {
            this.number = number;
            likeBand = 2;
        }
    }
}

