#include <iostream>
#include <stack>
#include <array>
using namespace std;

int main() {
    // Массив
    int numbers[] = {10, 20, 30, 40, 50};
    cout << "Массив: ";
    for (int value : numbers) cout << value << " ";
    cout << endl;
    
    // Стек
    stack<int> dataStack;
    dataStack.push(100);
    dataStack.push(200);
    dataStack.push(300);
    
    cout << "Текущий верхний элемент стека: " << dataStack.top() << endl;
    cout << "Извлекаем элемент: " << dataStack.top() << endl;
    dataStack.pop();
    cout << "Новый верхний элемент после извлечения: " << dataStack.top() << endl;
    
    return 0;
}
