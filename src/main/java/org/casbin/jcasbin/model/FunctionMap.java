// Copyright 2017 The casbin Authors. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.casbin.jcasbin.model;

import com.googlecode.aviator.runtime.type.AviatorFunction;
import org.casbin.jcasbin.util.function.KeyMatchFunc;
import org.casbin.jcasbin.util.function.KeyMatch2Func;
import org.casbin.jcasbin.util.function.RegexMatchFunc;
import org.casbin.jcasbin.util.function.IPMatchFunc;

import java.util.HashMap;
import java.util.Map;

/**
 * FunctionMap represents the collection of Function.
 */
public class FunctionMap {
    /**
     * AviatorFunction represents a function that is used in the matchers, used to get attributes in ABAC.
     */
    public Map<String, AviatorFunction> fm;

    /**
     * addFunction adds an expression function.
     */
    public void addFunction(String name, AviatorFunction function) {
        fm.put(name, function);
    }

    /**
     * loadFunctionMap loads an initial function map.
     */
    public static FunctionMap loadFunctionMap() {
        FunctionMap fm = new FunctionMap();
        fm.fm = new HashMap<>();

        fm.addFunction("keyMatch", new KeyMatchFunc());
        fm.addFunction("keyMatch2", new KeyMatch2Func());
        fm.addFunction("regexMatch", new RegexMatchFunc());
        fm.addFunction("ipMatch", new IPMatchFunc());

        return fm;
    }
}
