#include <stdlib.h>

#include <iostream>
#include <vector>

void print2DVector(const std::vector<std::vector<int>>& matrix) {
    for (std::vector<int> row : matrix) {
        std::cout << "[";
        for (int i = 0; i < row.size(); i++) {
            if (i != row.size() - 1) {
                std::cout << row.at(i) << ", ";
            } else {
                std::cout << row.at(i);
            }
        }
        std::cout << "]" << std::endl;
    }
    std::cout << std::endl;
}

void rotateMatrix(std::vector<std::vector<int>>& matrix) {
    std::vector<std::vector<int>> newIndexes(matrix.size() * matrix.size(), std::vector<int>(1, 0));
    int index = 0;
    for (int row = 0; row < matrix.size(); row++) {
        for (int col = 0; col < matrix[row].size(); col++) {
            int newRow = col;
            int newCol = matrix.size() - row - 1;
            newIndexes[index] = std::vector<int>{newRow, newCol, matrix[row][col]};
            index++;
        }
    }
    for (std::vector<int> mapping : newIndexes) {
        int newRow = mapping[0], newCol = mapping[1], val = mapping[2];
        matrix[newRow][newCol] = val;
    }
}

int main() {
    std::vector<std::vector<int>> matrix(8, std::vector<int>(8, 0));
    for (int i = 0; i < matrix.size(); i++) {
        for (int j = 0; j < matrix[i].size(); j++) {
            matrix[i][j] = rand() % 10 + 1;
        }
    }
    print2DVector(matrix);
    rotateMatrix(matrix);
    print2DVector(matrix);
    return 0;
};