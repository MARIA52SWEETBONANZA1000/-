#include <iostream>
#include <unordered_map>
#include <string>

int main() {
    std::unordered_map<std::string, int> catalog;

    catalog["car"] = 10;
    catalog["bike"] = 7;

    std::cout << catalog["car"] << std::endl; // 10

    return 0;
}