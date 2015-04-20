/**
 * Package for BaseDao interface implementations.
 * All classes manage sessions and transactions by themselves, every function runs in a separate session and transaction.
 * These classes are useful for simple one-operation tasks. They provide a way to perform easy operations
 * such as save, etc, without a need to open sessions, transactions and manage exceptions.
 */
package com.soft.library.dataBase.dao.isolated;