#include <stdlib.h>

#include <ctime>
#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>

void print2DVector(const std::vector<std::vector<int>>& matrix) {
    for (std::vector<int> row : matrix) {
        std::cout << "[";
        for (int i = 0; i < row.size(); i++) {
            std::cout << row.at(i) << (i != row.size() - 1 ? ", " : "");
        }
        std::cout << "]" << std::endl;
    }
    std::cout << std::endl;
}

void zeroMatrix(std::vector<std::vector<int>>& matrix) {
    std::unordered_set<int> rowSet, colSet;
    for (int row = 0; row < matrix.size(); row++) {
        for (int col = 0; col < matrix[row].size(); col++) {
            if (matrix[row][col] == 0) {
                rowSet.emplace(row);
                colSet.emplace(col);
            }
        }
    }
    for (int row = 0; row < matrix.size(); row++) {
        for (int col = 0; col < matrix[row].size(); col++) {
            if (rowSet.count(row) > 0 || colSet.count(col) > 0) {
                matrix[row][col] = 0;
            }
        }
    }
}

int main() {
    srand(time(NULL));
    int numRows = rand() % 10 + 1, numCols = rand() % 10 + 1;
    std::vector<std::vector<int>> matrix(numRows, std::vector<int>(numCols, 0));
    for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numCols; j++) {
            matrix[i][j] = rand() % 10;
        }
    }
    print2DVector(matrix);
    zeroMatrix(matrix);
    print2DVector(matrix);
    return 0;
}