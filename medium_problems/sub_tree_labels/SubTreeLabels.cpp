#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    vector<int> countSubTrees(int n, vector<vector<int>> &edges, string labels)
    {
        printEdges(edges);
    }

private:
    void printEdges(vector<vector<int>> &edges)
    {
        for (int i : edges[0])
            cout << i << endl;
    }
};

int main()
{
    Solution testSolution;
    // = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
    vector<int> &nodes;
    vector<vector<int>> &edges;
    nodes.push_back()
    edges.push_back({})
    
    testSolution.countSubTrees(7, edges, "abaedcd");
}