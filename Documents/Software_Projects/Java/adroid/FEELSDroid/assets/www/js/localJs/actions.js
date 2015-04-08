/**
 * Created by menaka on 4/9/15.
 */

function validate(){
    var x = document.forms["myForm"]["regno"].value;
    if(x==null || x==""){
        alert("Enter your Registration Number");
        return false;
    }
}
