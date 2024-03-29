/*
 *  Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.alibaba.fescar.rm.datasource.undo;

import com.alibaba.druid.util.JdbcConstants;
import com.alibaba.fescar.common.exception.NotSupportYetException;
import com.alibaba.fescar.rm.datasource.undo.mysql.keyword.MySQLKeywordChecker;
import com.alibaba.fescar.rm.datasource.undo.oracle.keyword.ORACLEKeywordChecker;

/**
 * @author Wu
 * @date 2019/3/5
 * The Type keyword checker factory
 */
public class KeywordCheckerFactory {

    /**
     * get keyword checker
     *
     * @param dbType
     * @return
     */
    public static KeywordChecker getKeywordChecker(String dbType) {
        if (dbType.equals(JdbcConstants.MYSQL)) {
            return MySQLKeywordChecker.getInstance();
        } else  if (dbType.equals(JdbcConstants.ORACLE)) {
            return ORACLEKeywordChecker.getInstance();
        } else {
            throw new NotSupportYetException(dbType);
        }

    }
}
