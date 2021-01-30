fun main(){
    print(sqrt(12))
}
private fun sqrt(x:Int):Int{
    for(i in 0 until x/2+1){
        if (i*i<=x && (i+1)*(i+1)>x)return i
    }
    return 1
}