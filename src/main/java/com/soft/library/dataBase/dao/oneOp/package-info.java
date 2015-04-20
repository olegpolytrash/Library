/**
 * Package for BaseDao interface implementations.
 * All classes manage sessions and transactions by themselves, every function runs in a separate session and transaction.
 * These classes are useful for simple one-operation tasks. They provide a way to simply do easy operations,
 * such as save, etc, without a need to open sessions, transactions, manage exceptions and so on.
 */
package com.soft.library.dataBase.dao.oneOp;