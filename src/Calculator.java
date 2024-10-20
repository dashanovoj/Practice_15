/* Напишите программу калькулятор, используя пример в листинге
15.6. Реализуйте помимо сложения вычитание, деление и умножение для двух
чисел, которые вводятся с клавиатуры. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Калькулятор");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Панель для полей ввода
        Panel inputPanel = new Panel();
        // Вертикальная компоновка для полей ввода
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));

        // Текстовые поля для чисел

        // Поле для первого числа
        TextField num1Field = new TextField();
        num1Field.setBounds(50, 50, 100, 20);
        inputPanel.add(num1Field);

        // Добавляем название для поля
        Label num1Label = new Label("Первое число");
        num1Label.setBounds(160, 50, 60, 20);
        inputPanel.add(num1Label);

        // Поле для второго числа
        TextField num2Field = new TextField();
        num2Field.setBounds(50, 80, 100, 20);
        inputPanel.add(num2Field);

        // Добавляем название для поля
        Label num2Label = new Label("Второе число");
        num2Label.setBounds(160, 80, 60, 20);
        inputPanel.add(num2Label);

        // Текстовое поле для результата
        TextField resultField = new TextField();
        resultField.setBounds(50, 110, 100, 20);
        resultField.setEditable(false); // Запрещаем редактирование
        inputPanel.add(resultField);

        // Добавляем название для поля
        Label resultLabel = new Label("Результат");
        resultLabel.setBounds(160, 110, 60, 20);
        inputPanel.add(resultLabel);

        // Добавляем панель с полями ввода в фрейм
        frame.add(inputPanel);

        // Кнопки для операций

        // Панель для кнопок
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));

        // Сложение

        Button addButton = new Button("+");
        addButton.setBounds(50, 140, 50, 30);
        // Добавляем обработку события (нажатия на кнопку сложения)
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Получаем с окон значения, преобразуем String в Double
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = num1 + num2; // получаем результат
                    resultField.setText(String.valueOf(result)); // передаём его в окно вывода
                } catch (NumberFormatException ex) { // строка не имеет соответствующего формата
                    resultField.setText("Ошибка ввода");
                }
            }
        });
        buttonPanel.add(addButton); // добавляем кнопку к панели

        // Вычитание
        Button subtractButton = new Button("-");
        subtractButton.setBounds(110, 140, 50, 30);
        // Добавляем обработку события (нажатия на кнопку вычитания)
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Получаем с окон значения, преобразуем String в Double
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = num1 - num2; // получаем результат
                    resultField.setText(String.valueOf(result)); // передаём его в окно вывода
                } catch (NumberFormatException ex) { // строка не имеет соответствующего формата
                    resultField.setText("Ошибка ввода");
                }
            }
        });
        buttonPanel.add(subtractButton);// добавляем кнопку к панели


        // Умножение
        Button multiplyButton = new Button("*");
        multiplyButton.setBounds(50, 180, 50, 30);
        // Добавляем обработку события (нажатия на кнопку умножения)
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Получаем с окон значения, преобразуем String в Double
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = num1 * num2; // получаем результат
                    resultField.setText(String.valueOf(result)); // передаём его в окно вывода
                } catch (NumberFormatException ex) { // строка не имеет соответствующего формата
                    resultField.setText("Ошибка ввода");
                }
            }
        });
        buttonPanel.add(multiplyButton); // добавляем кнопку к панели

        // Деление
        Button divideButton = new Button("/");
        // Добавляем обработку события (нажатия на кнопку деления)
        divideButton.setBounds(110, 180, 50, 30);
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Получаем с окон значения, преобразуем String в Double
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    if (num2 == 0) { // учитываем невозможность деления на ноль
                        resultField.setText("Деление на ноль!");
                    } else {
                        double result = num1 / num2; // получаем результат
                        resultField.setText(String.valueOf(result)); // передаём его в окно вывода
                    }
                } catch (NumberFormatException ex) {
                    resultField.setText("Ошибка ввода"); // строка не имеет соответствующего формата
                }
            }
        });
        buttonPanel.add(divideButton); // добавляем кнопку к панели

        // Добавляем панели с кнопками в фрейм
        frame.add(buttonPanel);
        frame.setVisible(true);
    }
}
