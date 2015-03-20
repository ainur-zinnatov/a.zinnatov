ќтображение таблиц (tableViewer)
Ќеобходимо сделать программу дл€ отображени€ произвольной табличной структуры в консоли. ƒолжен быть реализован класс ConsoleTableViewer<T>, при вызове метода show() которого происходит отрисовка таблицы в консоли.  роме того в этом классе есть  методы setModelProvider(ModelProvider<T>) и setLabelProvier(LabelProvider<T>)
ModelProvider - имеет методы T[] getElements() дл€ получени€ моделей-строк, метод Comparator<T> getComparator() дл€ сортировки строк по нужному принципу
LabelProvider - int getColumnCount(), String getHeader(int), String getLabel(T, int)
