package al10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhengtengfei on 2018/11/29.
 */
public class FullPermutation {
    public static void solvation(int[] arr, int n, int k){
        if (k == 1){
            for (int temp : arr){
                System.out.print(temp);
            }
            System.out.println();
        }
        for (int i = 0; i < k; i++){
            int temp = arr[i];
            arr[i] = arr[k-1];
            arr[k-1] = temp;

            solvation(arr,n,k-1);

            temp = arr[i];
            arr[i] = arr[k-1];
            arr[k-1] = temp;
        }
    }

    static class UserDto {
        private String userId;
        private String gc;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getGc() {
            return gc;
        }

        public void setGc(String gc) {
            this.gc = gc;
        }

        @Override
        public String toString() {
            return "UserDto{" +
                    "userId='" + userId + '\'' +
                    ", gc='" + gc + '\'' +
                    '}';
        }
    }
    static class Msg extends UserDto {
        private String pushId;

        public String getPushId() {
            return pushId;
        }

        public void setPushId(String pushId) {
            this.pushId = pushId;
        }

//        @Override
//        public String toString() {
//            return "Msg{" +
//                    "userId='" + userId + '\'' +
//                    ", gc='" + gc + '\'' +
//                    ", pushId='" + pushId + '\'' +
//                    '}';
//        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
//        int[] arr = new int[]{1,2,3,5,8,9,8,7,32,2,1};
//        solvation(arr,arr.length,arr.length);

        // test fater class
//        List<Msg> msgList = new ArrayList<>();
//        Msg m = new Msg();
//        m.setUserId("a");
//        m.setPushId("b");
//        m.setGc("c");
//        msgList.add(m);
//        UserDto userDto = (UserDto) m;
//        System.out.println(userDto);
//        System.out.println(m);

        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o1 == o2);

        Map<String,String> set = new HashMap<>();
        set.put("userId","ad");
        set.put("gc","gc");
        Map<String,Method> methodMap = new HashMap<>();
        UserDto userDto = new UserDto();
        Method[] methods = UserDto.class.getMethods();
        for (Method method : methods){
            if (method.getName().startsWith("set")){
                String field = method.getName().substring(method.getName().indexOf("set") + 3);
                field = field.toLowerCase().charAt(0) + field.substring(1);
                if (!methodMap.containsKey(field)){
                    methodMap.put(field,method);
                }
            }
        }
        for (String key : set.keySet()){
            String value = set.get(key);
            Method method = methodMap.get(key);
            if (method!=null){
                method.invoke(userDto,value);
            }
        }

        System.out.println(userDto);
    }
}
