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

package com.guoanjia.business.base.entity.jpa;

import com.github.asherli0103.core.jpa.domain.BaseRepository;
import com.guoanjia.business.base.entity.WxUserActivity;
import org.springframework.stereotype.Repository;

/**
 * 微信用户Repository
 *
 * @author AsherLi0103
 * @version 1.0.00
 */
@Repository
public interface WxUserActivityRepository extends BaseRepository<WxUserActivity, String> {

}
