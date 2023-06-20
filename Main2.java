package labödevi;
//Zeynep Kılıç  22120205065


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main2 {
 public static void main(String[] args) {
     Dosya_Kontrol.dosya_kontrol();
}}

class Dosya_Kontrol {
 public static void dosya_kontrol(){
     String fileName = "test_arazi.txt";
     int böcekSayisi = 0;

     try (BufferedReader dosya_oku = new BufferedReader(new FileReader(fileName))) {
         String line;

         while ((line = dosya_oku.readLine()) != null) {
             if (line.contains("|    _")) {
                 String nextLine = dosya_oku.readLine();
                 if (nextLine != null && nextLine.contains("###O")) {
                     String thirdLine = dosya_oku.readLine();
                     if (thirdLine != null && thirdLine.contains("|")) {
                         int eklenen = 0;
                         for (char c : thirdLine.toCharArray()) {
                             if (c == '|') {
                                 eklenen++; //bir satırda birden fazla böcek kullanılıyor mu bunu kontrol eder
                             }
                             //Satır satır dosyayı okuyup karakterleri kontrol ettik
                         }
                         böcekSayisi += eklenen;
                     }
                 }
             }
         }
         System.out.println("Toplam böcek sayisi: "+böcekSayisi);
     } catch (IOException e) {
         System.out.println("Dosya okunurken bir hata oluştu: " + e.getMessage());
     }
 }}
 