package cn.cloudscope.basic.bean.vo;

import lombok.Data;

/**
 * 统一返回实例
 * @author wupanhua
 * @date 18-7-3 下午2:28
 */
@Data
public class JsonResult<T> {

   // 返回代号
   private Integer code;
   // 返回信息
   private String msg;
   // 返回数据
   private T data;

   public JsonResult() {
   }

   public JsonResult(Integer code, String msg, T data) {
      this.code = code;
      this.msg = msg;
      this.data = data;
   }

   public JsonResult(Integer code, String msg) {
      this.code = code;
      this.msg = msg;
   }

   /**
    * 实例一个JsonResult
    * @param code 返回代码
    * @param msg 返回信息
    * @param data 返回数据
    * @return 结果
    * @author wupanhua
    */
   public static JsonResult getInstent(Integer code, String msg, Object data) {
      return new JsonResult(code, msg, data);
   }


   /**
    * 实例一个JsonResult
    * @param code 返回代码
    * @param msg 返回信息
    * @return 结果
    * @author wupanhua
    */
   public static JsonResult getInstent(Integer code, String msg) {
      return new JsonResult(code,msg);
   }
}
