public class Result {

    String result = "";

    public Result(String input){
        result = input;
    }

    public void addLine(String input){
        result += "\n" + input;
    }

    public void add(String input){
        result += input;
    }

    public String getResult(){
        return result;
    }

}
