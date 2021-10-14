/*
 * 蘑菇街 Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 *
 * Author: wuya
 * Create Date: 2015年10月29日 下午10:36:27
 */

package com.mogujie.jarvis.core.expression;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;

@Data
@AllArgsConstructor
public abstract class ScheduleExpression implements Expression {

    protected String expression;

    abstract public DateTime getTimeBefore(DateTime dateTime);

    abstract public DateTime getTimeAfter(DateTime dateTime);
}
