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

package com.guoanjia.business.blessing.service;

import com.github.asherli0103.core.entity.AjaxJson;
import com.github.asherli0103.core.jpa.service.BaseService;
import com.guoanjia.business.blessing.entity.WxCapitalPool;
import com.guoanjia.business.blessing.entity.WxMessageCode;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author AsherLi0103
 * @version 1.0.00
 */
public interface WxMessageCodeService extends BaseService<WxMessageCode,String> {

     void saveCode(WxMessageCode wxMessageCode);

     AjaxJson getCode(String userphone, String vcode);
}
