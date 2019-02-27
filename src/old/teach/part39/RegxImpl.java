package old.teach.part39;

/**
 * Created by zhengtengfei on 2019/2/27.
 * 回朔算法实现正则匹配
 */
public class RegxImpl {
    boolean regx = false;
    /**
     * 源字符串，目标字符串，源开始下标，当前匹配下标，目标当前下标
     */
    public void rmatch(String source,String target,int sourceIndex,int targetIndex){
        if (regx) return;
        if (targetIndex == target.length()){
            if (sourceIndex == source.length()) regx = true;
            return ;
        }
        if (target.indexOf(targetIndex) == '*'){
            for (int i = 0; i < source.length() - sourceIndex; i++)
                rmatch(source,target,sourceIndex+i,targetIndex+1);
        }else if (target.indexOf(targetIndex) == '?'){
            rmatch(source,target,sourceIndex+1,targetIndex+1);
            rmatch(source,target,sourceIndex,targetIndex+1);
        }else if (targetIndex < target.length() && source.indexOf(sourceIndex) == target.indexOf(targetIndex)){
            rmatch(source,target,sourceIndex+1,targetIndex+1);
        }
    }

    public static void main(String[] args) {
        RegxImpl regx = new RegxImpl();
        regx.rmatch("abcdca","abcd?a",0,0);
        System.out.println(regx.regx);
    }
}
