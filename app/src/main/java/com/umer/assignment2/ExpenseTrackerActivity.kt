package com.umer.assignment2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ExpenseTrackerActivity : AppCompatActivity() {
    private var etExpenseName: EditText? = null
    private var etExpenseAmount: EditText? = null
    private var tvTotalAmount: TextView? = null
    private var lvExpenses: ListView? = null
    private var expenses: ArrayList<String>? = null
    private var expensesAdapter: ArrayAdapter<String>? = null
    private var totalAmount = 0.0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_tracker)

        etExpenseName = findViewById(R.id.etExpenseName)
        etExpenseAmount = findViewById(R.id.etExpenseAmount)
        tvTotalAmount = findViewById(R.id.tvTotal)
        lvExpenses = findViewById(R.id.lvExpenses)
        val btnAddExpense = findViewById<Button>(R.id.btnAddExpense)

        expenses = ArrayList()
        expensesAdapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,
            expenses!!
        )
        lvExpenses?.adapter = expensesAdapter

        btnAddExpense.setOnClickListener {
            val expenseName = etExpenseName?.text.toString()
            val expenseAmountStr = etExpenseAmount?.text.toString()
            if (expenseName.isNotEmpty() && expenseAmountStr.isNotEmpty()) {
                val expenseAmount = expenseAmountStr.toDouble()
                totalAmount += expenseAmount
                expenses!!.add("$expenseName: $$expenseAmount")
                expensesAdapter!!.notifyDataSetChanged()
                tvTotalAmount?.text = "Total: $$totalAmount"
            } else {
                Toast.makeText(
                    this,
                    "Please enter both name and amount",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
