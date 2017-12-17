package com.ray.userCenter.exception;

/**
 * Created by Administrator on 2017/12/11 0011.
 */
public class ParameterException extends Exception{

        public ParameterException(String msg) {
            super(msg);
        }

        public ParameterException(Throwable cause) {
            super(cause);
        }

        public ParameterException(String msg, Throwable cause) {
            super(msg, cause);
        }

}
