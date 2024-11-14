package com.dat.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RemoveSubFoldersFilesystem {
    public static void main(String[] args) {
        RemoveSubFoldersFilesystem removeSubFoldersFilesystem = new RemoveSubFoldersFilesystem();
        String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        System.out.println( removeSubFoldersFilesystem.removeSubfolders(folder));
    }
    public List<String> removeSubfolders(String[] folder) {
        Set<String> res = new HashSet<>();
        Folder root = new Folder();
        root.value = "";
        Arrays.sort(folder);
        buildTrie(folder, root);

        findRootFolder(res, root, folder);
        return new ArrayList<>(res);
    }

    private void findRootFolder(Set<String> res, Folder root, String[] folder) {
        Folder temp;
        for (String f :folder) {
            StringBuilder sb = new StringBuilder("/");
            String[] subFolders = f.split("/");
            temp = root;
            int i = 1;
            while (temp != null) {
                temp = temp.children.get(subFolders[i++]);
                sb.append(temp.value);
                if (temp.isEnd)
                    break;
            }
            res.add(sb.toString());
        }
    }

    private void buildTrie(String[] folder, Folder root) {
        for (String f :folder) {
            String[] subFolders = f.split("/");
            root.build(subFolders, 1);
        }
    }

    static class Folder {
        private Map<String, Folder> children;
        private String value;
        private boolean isEnd;

        public Folder() {
            children = new HashMap<>();
        }

        public Folder(String value) {
            this.children = new HashMap<>();
            this.value = value;
        }


        public void build(String[] subFolders, int i) {
            int n = subFolders.length;

            String current = subFolders[i];
            Folder child;
            if (children.containsKey(current)) {
                child = children.get(current);
            } else {
                child = new Folder(current);
                children.put(current, child);
            }

            if (i + 1 == n) {
                child.isEnd = true;
            } else {
                child.build(subFolders, i + 1);
            }
        }
    }
}
