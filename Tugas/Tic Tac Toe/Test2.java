import java.util.Scanner;

public class Test2 {
    public static boolean selesai = false;

    public static Scanner scanner = new Scanner(System.in);
    public static char papan[] = {
        '_', '_', '_',
        '_', '_', '_',
        '_', '_', '_'
    };

    public static int menang[][] = {
        //vertical
        {0, 3, 6},
        {1, 4, 7},
        {2, 5, 8},

        //horizontal
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8},

        //silang 
        {0, 4, 8},
        {2, 4, 6}
    };

    public static int langkah = 0; // 0 = O, 1 = X;

    public static void drawBoard(){
        for(int i=0; i<3; i++){
            System.out.print("| ");
            for(int j=0; j<3; j++){
                System.out.print(papan[i*3 + j] + " | ");
            }
            System.out.println();
            if(i!=2)
                System.out.println("----|---|----");
        }
    }

    public static char penanda(){
        return langkah == 0 ? 'O' : 'X';
    }

    public static boolean winner = false;
        
    public static boolean menang(char tanda) {
        for (int i = 0; i < menang.length; i++) {
            boolean flag = true; 
    
            for (int j = 0; j < 3; j++) {
                if (papan[menang[i][j]] != tanda) {
                    flag = false;
                    break; 
                }
            }
    
            if (flag) { 
                return true;
            }
        }
        return false;
    }
    

    public static boolean placeMove(int x, int y){
        if (x < 0 || x > 2 || y < 0 || y > 2) return false;
        
        if (papan[x * 3 + y]!= '_'){
            System.out.println("Koordinat sudah dipakai!");
            return false;
        }

        papan[x * 3 + y] = penanda();
        return true; 
    }

    public static boolean seri(){
        for (char c : papan) {
            if (c == '_') {
                return false; 
            }
        }
        return (!menang('X') && !menang('O'));
    }

    public static void playGame(){
        int x;
        int y;
        boolean validMove = false;
        do { 
            System.out.print((langkah == 0 ? "Player 1" : "PLayer 2") + "\n" + "Masukkan koordinat X dan Y: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka!");
                scanner.next(); // Membersihkan input yang salah
                continue;
            }
            x = scanner.nextInt() - 1;

            if (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka!");
                scanner.next(); // Membersihkan input yang salah
                continue;
            }

            y = scanner.nextInt() - 1;
            
            validMove = placeMove(x, y);

            if (!validMove){
                System.out.println("Koordinat salah!");
                continue;
            }
        } while (!validMove);
        
        drawBoard();

        if(menang(penanda())){
            System.out.println((langkah == 0? "Player 1" : "Player 2") + " menang!");
            selesai = true;
            return;
        }

        if (seri()){
            System.out.println("Seri!");
            selesai = true;
            return;
        }

        
        if (langkah == 0) langkah = 1;
        else langkah = 0;
    }
    public static void startGame(){
        System.out.println("Selamat datang di Tic Tac Toe!");
        drawBoard();
        while(!selesai){
            playGame();
        }
    }

    public static void main(String[] args) {
        startGame();
    }
}