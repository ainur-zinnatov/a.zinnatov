����������� ������ (tableViewer)
���������� ������� ��������� ��� ����������� ������������ ��������� ��������� � �������. ������ ���� ���������� ����� ConsoleTableViewer<T>, ��� ������ ������ show() �������� ���������� ��������� ������� � �������. ����� ���� � ���� ������ ����  ������ setModelProvider(ModelProvider<T>) � setLabelProvier(LabelProvider<T>)
ModelProvider - ����� ������ T[] getElements() ��� ��������� �������-�����, ����� Comparator<T> getComparator() ��� ���������� ����� �� ������� ��������
LabelProvider - int getColumnCount(), String getHeader(int), String getLabel(T, int)
