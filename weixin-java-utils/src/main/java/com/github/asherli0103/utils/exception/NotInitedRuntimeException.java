/*
 * Copyright  (c) 2017. By AsherLi0103
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.asherli0103.utils.exception;


/**
 * 未初始化异常
 *
 * @author xiaoleilu
 */
public class NotInitedRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 8247610319171014183L;

    public NotInitedRuntimeException(Throwable e) {
        super(e);
    }

    public NotInitedRuntimeException(String message) {
        super(message);
    }

    public NotInitedRuntimeException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
