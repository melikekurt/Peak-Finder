/* 
BIL-201 ODEVI
Melike Kurt 20120205009

*/
import java.util.Random;

public class PeakFinder {

    /**
     * generate random 2D array
     */ 
    
    public int[][] random2dArray(int n, int m){
        int[][] a = new int[n][];
        Random r = new Random();
        for(int i = 0; i < n; i++){
            a[i] = new int[m];
            for (int j = 0; j < a[i].length; j++){
                a[i][j] = r.nextInt(20);
            }
        }
        return a;
        

    }
    //print 2D array
    public void print2d(int[][] a){
        for (int[] i: a){
            for (int item: i){
                System.out.print(item+"\t ");
            }
            System.out.println("");        
        }
    }

    /**
     * n = number of rows,
     * m = number of columns
     * rowOrcol -> eger 0 ise sadece satirlari(n) bolecek
     *          eger 1 ise sadece sutunlari(m) bolecek
     *          eger 2 ise bir iterasyonda satirlari, diger iterasyonda sutunlari bolecek
     *              (m ve n degerlerinden buyuk olani bolebilirsiniz, 
     *              bu m ve n degerleri arasaindaki fark fazla oldugunda daha mantikli.)
     */ 
    
        public int[] peakFinder2D(int[][] a, int n, int m, int rowOrcol){
        // satir sutun ve bulunan maxin indexini tutmak icin gerekli atamalar yapilir    
        int[] indx = new int[2];
        int startR = 0, endR = n, startC = 0, endC = m; 
        int mid;
        //rowOrcol 0 durummunda  satirlara bolme islemi yapiyoruz yani midi satirin yarisindan baslatiyoruz
       if(rowOrcol==0){ 
           while(startR >= 0 && endR <= n ){
            mid = (startR+endR)/2;
            int max = a[mid][startC];
            int imax = 0;
            //secilen satirdaki en buyuk sayi bulunuyor
            for(int i = startC; i < endC; i++){
                if(max<a[mid][i]){
                    max = a[mid][i];
                    imax = i;
                }
            } 
            //komsularina bakiliyor en buyuk bulunana kadar while donuyor ve en buyuk return ediliyor
            if(a[mid][imax] < a[mid+1][imax]){
                startR = mid+1; 
            }else if(a[mid][imax] < a[mid-1][imax]){
                endR = mid-1;
            }else {
                indx[0] = mid;
                indx[1] = imax;
                return indx;
            }
        }
    }
     //rowOrcol 1 durummunda  sutunlara bolme islemi yapiyoruz yani midi sutunun yarisindan baslatiyoruz
        else if(rowOrcol==1){
            while(startC >= 0 && endC <= n ){
                mid = (startC+endC)/2;
                int max = a[startR][mid];
                int imax = 0;
                //secilen sutundaki en buyuk sayi bulunuyor
                for(int i = startR; i < endR; i++){
                    if(max<a[i][mid]){
                        max = a[i][mid];
                        imax = i;
                    }
                } 
            //komsularina bakiliyor en buyuk bulunana kadar while donuyor ve en buyuk return ediliyor
                if(a[imax][mid] < a[imax][mid+1]){
                    startC = mid+1;
                }else if(a[imax][mid] < a[imax][mid-1]){
                    endC = mid-1;
                }else {
                    indx[0] = imax;
                    indx[1] = mid;
                    return indx;
                
            }
        }
    }
    //rowOrcol 2 durummunda  hem satirlara hem sutunlara bolme islemi yapiyoruz 
        else if(rowOrcol==2){
            int iterasyon=0;
            //iterasyon sirasina gore degiseceginden iterasyon ciftken satirlara tekken sutunlara boluyor ve islemler aynen devam ediyor
            if(iterasyon%2==0){
            while(startR >= 0 && endR <= n ){
                mid = (startR+endR)/2;//orta satirin indexi
                int max = a[mid][startC];
                int imax = 0;
                for(int i = startC; i < endC; i++){
                    if(max<a[mid][i]){
                        max = a[mid][i];
                        imax = i;//imax sutun indexi 
                    }
                } 
                iterasyon++;
                if(a[mid][imax] < a[mid+1][imax]){
                    startR = mid+1; 
                }else if(a[mid][imax] < a[mid-1][imax]){
                    endR = mid-1;
                }else {
                    indx[0] = mid;
                    indx[1] = imax;
                    return indx;
                }
            } 
        }
        else if(iterasyon%2==1){
            while(startC >= 0 && endC <= n ){
                mid = (startC+endC)/2;
                int max = a[startR][mid];
                int imax = 0;
                for(int i = startR; i < endR; i++){
                    if(max<a[i][mid]){
                        max = a[i][mid];
                        imax = i;
                    }

                } 
                iterasyon++;
                if(a[imax][mid] < a[imax][mid+1]){
                    startC = mid+1;
                }else if(a[imax][mid] < a[imax][mid-1]){
                    endC = mid-1;
                }else {
                    indx[0] = imax;
                    indx[1] = mid;
                    return indx;
                
            }
        }
    }
}
        return indx;

    
}




    /**
     * uc boyutlu arrayde peak bulan method
     * @param a
     * @param x
     * @param y
     * @param z
     * @return
     */
    // generate random 3d array
    public int[][][] random3dArray(int x, int y, int z){
        int[][][] a = new int[x][y][z];
        Random r = new Random();

        for(int i=0; i<z ;i++){
            for(int j=0; j<y ; j++){
                for(int k=0; k<x ; k++){
                    a[k][j][i]= r.nextInt(20);
                }
            }
        }

        return a;
    }
    public int[] peakFinder3d(int[][][] a, int x, int y, int z){
        
        //3 boyut oldugundan gerekli atamalar yapilir.
        int[] index = new int[3];
        int startR = 0, endR = x, startC = 0, endC = y, startA = 0, endA = z;
        int mid;
        //Sınırlar ucuncu boyuta gore verilip mid belirlenir.
        while(startA>=0 && endA<=z){ //logz
            mid=(startA+endA)/2;
            //ortadaki iki boyutlu array alinir.
            int max = a[startR][startC][mid];
            int imax=0;
            int jmax=0;
            //max bulunur ve indexleri alinir
            for(int i = startR; i < endR; i++){ //n+1
                for(int j=startC; j < endC; j++){ //m+1
                    if(max < a[i][j][mid]){ //n+1*m+1
                        
                        max = a[i][j][mid];
                        imax = i;
                        jmax= j ;
                    }
                }

            }
            //bulunan max komşulari ile karşilaştirilir ve en buyuk bulunana kadar while doner ve en buyuk olan return edilir
            if(a[imax][jmax][mid] < a[imax][jmax][mid+1]){ //logz
                startA=mid+1;
            }else if(a[imax][jmax][mid] < a[imax][jmax][mid-1]){
                endA=mid-1;
            }else{
                index[0]=imax;
                index[1]=jmax;
                index[2]=mid;
                return index;
            }

        }
        return index;
    }
    
    public static void main(String[] args){
        PeakFinder pf = new PeakFinder();
        int n = 10000, m = 50, rowOrcol = 2;
        
        
        int[][] a = pf.random2dArray(n,m);
        
        
        long t1 = System.nanoTime();
       
        int[] x = pf.peakFinder2D(a, n, m, rowOrcol);
        System.out.println(x[0]+" "+x[1]);
        pf.print2d(a);
        

        long t2 = System.nanoTime();
        
        
        System.out.printf("%d, %d, %d, %d", n,m, rowOrcol, t2-t1);
        
    }
}