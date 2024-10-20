import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu {
    public static void main(String[] args) {
        // Создаем основное окно
        JFrame frame = new JFrame("Выбор страны");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Создаем JComboBox (всплывающее меню, которое содержит список элементов) с названиями стран
        String[] countries = {"Australia", "China", "England", "Russia"}; // строковый массив стран
        JComboBox<String> countryComboBox = new JComboBox<>(countries); // передаём в экземпляр строковый массив

        // Создаем кнопку для подтверждения выбора
        JButton selectButton = new JButton("Выбрать");

        // Создаем текстовое поле для вывода результата
        JTextArea resultArea = new JTextArea(3, 20);
        resultArea.setEditable(false); // запрещаем редактирование
        resultArea.setLineWrap(true); // возможность переноса текста на следующую строку
        resultArea.setWrapStyleWord(true); // возможность переноса по словам

        // Добавляем обработку события (нажатия на кнопку)
        selectButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                String selectedCountry = (String) countryComboBox.getSelectedItem();
                String info = getCountryInfo(selectedCountry); // Получаем информацию о стране
                resultArea.setText(info); // Отображаем информацию в текстовой области
            }
        });

        // Добавляем компоненты в окно
        frame.add(new JLabel("Выберите страну:"));
        frame.add(countryComboBox);
        frame.add(selectButton);
        frame.add(new JScrollPane(resultArea)); // полоса прокрутки

        // Центрируем окно
        frame.setLocationRelativeTo(null);
        // Устанавливаем видимость окна
        frame.setVisible(true);
    }

    // Метод для получения информации о стране
    private static String getCountryInfo(String country) {
        switch (country) {
            case "Australia":
                return "Австралия: Страна и континент, известная своими уникальными природными ландшафтами.";
            case "China":
                return "Китай: Самая населённая страна в мире, известная своей древней культурой и историей.";
            case "England":
                return "Англия: Часть Великобритании, известная своей историей, культурой и архитектурой.";
            case "Russia":
                return "Россия: Самая большая страна в мире, известная своей богатой историей и культурным наследием.";
            default:
                return "Информация не найдена.";
        }
    }
}

