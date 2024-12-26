/**
 * Задание 3
 * На вход в качестве аргументов программы поступают три пути к файлу (в приложении
 * к заданию находятся примеры этих файлов):
 * ● values.json содержит результаты прохождения тестов с уникальными id
 * ● tests.json содержит структуру для построения отчета на основе прошедших
 * тестов (вложенность может быть большей, чем в примере)
 * ● report.json - сюда записывается результат.
 * Напишите программу, которая формирует файл report.json с заполненными полями
 * value для структуры tests.json на основании values.json.
 * Структура report.json такая же, как у tests.json, только заполнены поля “value”.
 * На вход программы передается три пути к файлу!
 */

import com.google.gson.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fvalues = args[0]; // src/main/java/org/example/f/values.json
        String ftests  = args[1]; // src/main/java/org/example/f/tests.json
        String freport = args[2]; // src/main/java/org/example/f/report.json

        File f = new File(freport);

        JsonObject JOvalues = JsonParser.parseReader(new FileReader(fvalues)).getAsJsonObject();
        JsonObject JOtests  = JsonParser.parseReader(new FileReader(ftests)).getAsJsonObject();

        JsonArray JAvalues = JOvalues.get("values").getAsJsonArray();
        JsonArray JAtests  = JOtests.get("tests").getAsJsonArray();

        mergeArr(JAvalues, JAtests);

        FileWriter FWreport = new FileWriter(freport);
        FWreport.write(String.valueOf(JOtests));
        FWreport.close();
    }

    public static void mergeArr (JsonArray JAv, JsonArray JAt) {
        for(JsonElement t : JAt) {
            JsonObject JOt = t.getAsJsonObject();
            int IDtest = JOt.get("id").getAsInt();
            for(JsonElement v : JAv) {
                JsonObject JOv = v.getAsJsonObject();
                if(JOv.has("id") && JOv.get("id").getAsInt() == IDtest){
                    JsonPrimitive JPvalue = (JsonPrimitive) JOv.get("value");
                    JOt.add("value", JPvalue);
                    break;
                }
            }
            if(JOt.has("values")) mergeArr(JAv, JOt.get("values").getAsJsonArray());
        }
    }
}